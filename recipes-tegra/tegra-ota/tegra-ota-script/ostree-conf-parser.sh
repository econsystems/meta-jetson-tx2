#!/bin/bash

# PURPOSE: Process /boot/loader/entries/econ-os-1.conf and prepare uEnv.txt_prev



FILENAME=$1

count=0

touch /boot/uEnv.txt_prev
rm /boot/uEnv.txt_prev

cat $FILENAME | while read LINE

do

let count++

if [ "$count" -eq 1 ] ; then
 echo "ramdisk_image=$(echo ${LINE} | cut -d " " -f 2)" >> /boot/uEnv.txt_prev
 echo "bootdir=/ostree/$(echo ${LINE} | cut -d "/" -f 3)/" >> /boot/uEnv.txt_prev
fi

if [ "$count" -eq 2 ] ; then
 echo "ostree_bootargs=$(echo ${LINE} | cut -d " " -f 2)" >> /boot/uEnv.txt_prev
fi

if [ "$count" -eq 4 ] ; then
 echo "kernel_image=$(echo ${LINE} | cut -d " " -f 2)" >> /boot/uEnv.txt_prev
fi

done

echo "Updating commit_id environment"
cd /ostree/repo/refs
fw_setenv commit_id "$(cat $(find . -type f -name "0"))"
sync

