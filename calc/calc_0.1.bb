SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "libmath"

SRC_URI = "file://calculator.c"
			


S = "${WORKDIR}"

do_compile(){
	${CC}${CFLAGS}${LDFLAGS} calculator.c -o calc -L${STAGING_LIBDIR} -lmath -Wl,--hash-style=gnu
}

do_install(){
	install -d ${D}${bindir}
	install -m 0755 calc ${D}${bindir}
}
