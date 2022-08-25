#
#

SUMMARY = "Essential build dependencies"
LICENSE = "GPL"

inherit packagegroup

RDEPENDS_packagegroup-epiphany-sdk-buildessentialfromsource = "\
    epiphany-sdk \
    epiphany-sdk-dev \
    epiphany-elib-dev \
    epiphany-elib-staticdev \
    "
