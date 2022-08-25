#
#

SUMMARY = "Essential build dependencies"
LICENSE = "GPL"

inherit packagegroup

RDEPENDS_packagegroup-epiphany-elf-buildessentialfromsource = "\
    autoconf \
    automake \
    epiphany-binutils \
    epiphany-binutils-dbg \
    epiphany-binutils-dev \
    epiphany-binutils-staticdev \
    epiphany-binutils-symlinks \
    epiphany-gcc \
    epiphany-gcc-plugins \
    epiphany-g++ \
    epiphany-cpp  \
    epiphany-gcc-doc \
    epiphany-gcc-dbg \
    epiphany-gcc-dev \
    epiphany-gcc-runtime-dbg \
    epiphany-libstdc++-dev \
    epiphany-libstdc++-staticdev \
    epiphany-libgcc-dev \
    epiphany-gcov \
    epiphany-newlib-dev \
    epiphany-newlib-dev \
    epiphany-newlib-staticdev \
    epiphany-libgloss \
    epiphany-libgloss-dev \
    epiphany-libgloss-dbg \
    epiphany-libgloss-staticdev \
    gettext \
    make \
    libtool \
    pkgconfig \
    "
