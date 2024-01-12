SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://add.c \
			file://mathlib.c"

PROVIDES = "libmath"
			

S = "${WORKDIR}"

do_compile(){
	${CC} ${CFLAGS} -c mathlib.c -o mathlib.o
	ar rcs libmath.a mathlib.o

	${CC} ${CFLAGS} -c add.c -o add.o
	${CC}${CFLAGS}${LDFLAGS} mathlib.o add.o -o add -Wl,--hash-style=gnu
	#${CC}${CFLAGS}${LDFLAGS} add.c -o add
}

do_install(){
	install -d ${D}${libdir}
	install -m 0644 libmath.a ${D}${libdir}

	install -d ${D}${bindir}
	install -m 0755 add ${D}${bindir}
}
