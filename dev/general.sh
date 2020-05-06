#!/usr/bin/env bash
BOOK_PATCH_NAME=$1
KEY_PASS=$2
STOREPASS=$3
CN_NAME=$4
OU_NAME=$5
O_NAME=$6
L_NAME=$7
ST_NAME=$8
C_NAME=$9
D_NAME="CN=${CN_NAME},OU=${OU_NAME},O=${O_NAME},L=${L_NAME},ST=${ST_NAME},C=${C_NAME}"
echo ${BOOK_PATCH_NAME}+${KEY_PASS}+${STOREPASS}+${D_NAME}>>/data/config.log
keytool -genkeypair -keystore ${BOOK_PATCH_NAME} -keypass ${KEY_PASS} -storepass ${STOREPASS} -keyalg RSA -keysize 2048 -validity 3650 -dname ${D_NAME}
