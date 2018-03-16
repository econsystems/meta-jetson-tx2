#!/bin/bash

if [ "$1" == "PASS" ] ; then
  fw_setenv stage '9'
  fw_setenv status 'OK'
  watchdog-test -d >> /home/root/WDOG.txt
  fw_setenv bootcount 1
  fw_setenv BOOT_FAILURE_COMMIT_ID 'NONE'
  fw_setenv BOOT_FAILURE_REASON 'NONE'
else
  fw_setenv stage '9'
  fw_setenv status 'FAIL'
  fw_setenv bootcount '2'
  reboot
fi

