SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://sub.c \
			file://mathlib.c"
			


PROVIDES = "libmath"

S = "${WORKDIR}"

do_compile(){
	${CC} ${CFLAGS} -c mathlib.c -o mathlib.o
	ar rcs libmath.a mathlib.o

	${CC} ${CFLAGS} -c sub.c -o sub.o
	${CC}${CFLAGS}${LDFLAGS} mathlib.o sub.o -o sub -Wl,--hash-style=gnu
	#${CC}${CFLAGS}${LDFLAGS} sub.c -o sub
}

do_install(){
	install -d ${D}${libdir}
	install -m 0644 libmath.a ${D}${libdir}

	install -d ${D}${bindir}
	install -m 0755 sub ${D}${bindir}
}
