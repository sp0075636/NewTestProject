#!/bin/sh
count=1
if [ -e /tmp/output ]
then
if [ -d /tmp/output ]
then
echo "output directory exists"
fi
else
mkdir  /tmp/output
fi
IFS=$'\n'
for i in `cat $2`
do
search_string=$(echo $i|awk -F"=" '{print$1}')
replace_string=$(echo $i|awk -F"=" '{print$2}')
if [ "$count" == 1 ]
then
echo $count
sed "s/\[\[`echo $search_string`]]/`echo $replace_string`/" $1 >output1.html
else
sed "s/\[\[`echo $search_string`]]/`echo $replace_string`/" $1 >/tmp/output/index.html
fi
count=$(($count + 1))
done