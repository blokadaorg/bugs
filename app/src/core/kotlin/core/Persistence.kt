package core

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.get
import com.github.michaelbull.result.or
import core.bits.SlotStatusPersistence
import io.paperdb.Paper

class Persistence {
    companion object {
        const val DEFAULT_PATH = ""
        val global = GlobalPersistence()
        val slots = SlotStatusPersistence()
        val pause = TunnelPausePersistence()

        fun paper() = {
            with(Persistence.global.loadPath()) {
                if (!Persistence.global.usesDefaultPath()) Paper.bookOn(this)
                else Paper.book()
            }
        }()
    }
}

class GlobalPersistence {
    val loadPath = {
        val path = Result.of { Paper.book().read<String>("persistencePath", Persistence.DEFAULT_PATH) }
                .or { Ok(Persistence.DEFAULT_PATH) }.get()
        if (path.isNullOrBlank()) {
            if ((getActiveContext()?.filesDir != null)) {
                getActiveContext()?.filesDir?.absolutePath + "/"
            }else{
                e("could not get filesDir!")
                ""
            }
        }else{
            path
        }
    }

    val usesDefaultPath = {Result.of { Paper.book().read<String>("persistencePath", Persistence.DEFAULT_PATH) }
                .or { Ok(Persistence.DEFAULT_PATH) }.get() == Persistence.DEFAULT_PATH }

    val savePath = { path: String ->
        Result.of { Paper.book().write("persistencePath", path) }
    }
}
