#!/usr/bin/env bash
echo "hello world"
echo "hello world"
date
myUrl="https://www.google.com"
#readonly myUrl
#删除变量
#unset myUrl
echo $myUrl
#myUrl="https://www.runoob.com"
#for file in $(ls C:/Users/w/Downloads)
your_name='sbyangsheng'
str="Hello, I know you are \"$your_name\"! \n"
echo -e $str
echo ${#str}

string="runoob is a great site"
echo ${string:1:4} # 输出 unoo

str1='str1'
str2='str2'
echo $str1 $str2

exit 0