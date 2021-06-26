#!/usr/bin/env bash

array=("jones" "mike" "kobe" "jordan")
 for v in ${array[@]}
 do
  echo $v
 done
echo ${array[@]}
echo ${array[1]}
