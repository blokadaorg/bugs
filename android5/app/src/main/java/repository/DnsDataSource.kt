/*
 * This file is part of Blokada.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * Copyright © 2021 Blocka AB. All rights reserved.
 *
 * @author Karol Gusak (karol@blocka.net)
 */

package repository

import model.Dns
import model.DnsId

object DnsDataSource {

    val network = Dns.plaintextDns(
        id = "network",
        ips = listOf(),
        label = "Network DNS"
    )

    val blocka = Dns(
        id = "blocka2",
        ips = listOf("193.180.80.1", "193.180.80.2"),
        plusIps = listOf("193.180.80.100", "193.180.80.101"),
        label = "Blokada DNS",
        port = 443,
        name = "dns.blokada.org",
        path = "dns-query",
        canUseInCleartext = false
    )

    val cloudflare = Dns(
        id = "cloudflare",
        ips = listOf("1.1.1.1", "1.0.0.1", "2606:4700:4700::1111", "2606:4700:4700::1001"),
        port = 443,
        name = "cloudflare-dns.com",
        path = "dns-query",
        label = "Cloudflare"
    )

    fun getDns() = listOf(
        blocka,
        Dns(
            id = "adguard",
            ips = listOf("94.140.14.14", "94.140.15.15", "2a10:50c0::ad1:ff", "2a10:50c0::ad2:ff"),
            port = 443,
            name = "dns.adguard.com",
            path = "dns-query",
            label = "AdGuard"
        ),
        Dns(
            id = "adguard_family",
            ips = listOf("94.140.14.15", "94.140.15.16", "2a10:50c0::bad1:ff", "2a10:50c0::bad2:ff"),
            port = 443,
            name = "dns-family.adguard.com",
            path = "dns-query",
            label = "AdGuard: family"
        ),
        Dns.plaintextDns(
            id = "alternate",
            ips = listOf("76.76.19.19", "76.223.122.150", "2602:fcbc::ad", "2602:fcbc:2::ad"),
            label = "Alternate DNS"
        ),
        cloudflare,
        Dns(
            id = "cloudflare.malware",
            ips = listOf("1.1.1.2", "1.0.0.2", "2606:4700:4700::1112", "2606:4700:4700::1002"),
            port = 443,
            name = "security.cloudflare-dns.com",
            path = "dns-query",
            label = "Cloudflare: malware blocking"
        ),
        Dns(
            id = "cloudflare.adult",
            ips = listOf("1.1.1.3", "1.0.0.3", "2606:4700:4700::1113", "2606:4700:4700::1003"),
            port = 443,
            name = "family.cloudflare-dns.com",
            path = "dns-query",
            label = "Cloudflare: malware & adult blocking"
        ),
        Dns.plaintextDns(
            id = "digitalcourage",
            ips = listOf("46.182.19.48", "2a02:2970:1002::18"),
            label = "Digitalcourage",
            region = "europe"
        ),
        Dns.plaintextDns(
            id = "dismail",
            ips = listOf("80.241.218.68", "159.69.114.157", "2a02:c205:3001:4558::1", "2a01:4f8:c17:739a::2"),
            label = "Dismail",
            region = "europe"
        ),
        Dns(
            id = "dnswatch",
            ips = listOf("84.200.69.80", "84.200.70.40", "2001:1608:10:25::1c04:b12f", "2001:1608:10:25::9249:d69b"),
            port = 443,
            name = "resolver2.dns.watch",
            path = "dns-query",
            label = "DNS.Watch",
            region = "europe"
        ),
//        Dns.plaintextDns(
//            id = "freenom",
//            ips = listOf("80.80.80.80", "80.80.81.81"),
//            label = "Freenom"
//        ),
        Dns.plaintextDns(
            id = "fdn",
            ips = listOf("80.67.169.12", "80.67.169.40", "2001:910:800::12", "2001:910:800::40"),
            label = "French Data Network",
            region = "europe"
        ),
        Dns(
            id = "digitalegesellschaft",
            ips = listOf("185.95.218.42", "185.95.218.43", "2a05:fc84::42", "2a05:fc84::43"),
            port = 443,
            name = "dns.digitale-gesellschaft.ch",
            path = "dns-query",
            label = "Digitale Gesellschaft (Switzerland)",
            canUseInCleartext = false,
            region = "europe"
        ),
        Dns(
            id = "google",
            ips = listOf("8.8.8.8", "8.8.4.4", "2001:4860:4860::8888", "2001:4860:4860::8844"),
            port = 443,
            name = "dns.google",
            path = "resolve",
            label = "Google"
        ),
        Dns.plaintextDns(
            id = "opendns",
            ips = listOf("208.67.222.222", "208.67.220.220"),
            label = "Open DNS"
        ),
        Dns.plaintextDns(
            id = "opendns_family",
            ips = listOf("208.67.220.123", "208.67.222.123"),
            label = "Open DNS: family"
        ),
        Dns(
            id = "quad9",
            ips = listOf("9.9.9.9", "149.112.112.112", "2620:fe::fe", "2620:fe::9"),
            port = 443,
            name = "dns.quad9.net",
            path = "dns-query",
            label = "Quad9",
            region = "europe"
        ),
        Dns.plaintextDns(
            id = "quad101",
            ips = listOf("101.101.101.101", "101.102.103.104", "2001:de4::101", "2001:de4::102"),
            label = "Quad 101"
        ),
        Dns(
            id = "uncensored",
            ips = listOf("91.239.100.100", "89.233.43.71", "2001:67c:28a4::", "2a01:3a0:53:53::"),
            port = 443,
            name = "anycast.uncensoreddns.org",
            path = "dns-query",
            label = "Uncensored DNS",
            region = "europe"
        ),
        Dns.plaintextDns(
            id = "verisign",
            ips = listOf("64.6.64.6", "64.6.65.6", "2620:74:1b::1:1", "2620:74:1c::2:2"),
            label = "Verisign Public DNS"
        )
    )

    // All special cases and removed legacy needs to be handled here to not cause crashes when migrating
    fun byId(dnsId: DnsId) = when(dnsId) {
        network.id -> network
        else -> getDns().firstOrNull { it.id == dnsId } ?: cloudflare // Fallback for previously selected removed DNS
    }
}
