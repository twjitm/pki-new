#!/usr/bin/env bash
#导出证书
BOOK_PATCH=$1
STORE_PASS=$2
TO_CER_PATH=$3
keytool -export -keystore ${BOOK_PATCH} -storepass ${STORE_PASS} -rfc -file ${TO_CER_PATH}

