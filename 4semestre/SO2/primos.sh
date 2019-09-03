#!/bin/sh

number=3
primeNumberCounter=2


while [ $primeNumberCounter -lt 100 ]
do	
	i=2
	flag=0
	primo=0
	while [ $i -le `expr $number / 2` ]
	do
		if [ `expr $number % $i` -eq 0 ]
		then
			flag=1
		fi
		if [ $number -eq 1 ]
		then
			primo=0
		else
			if [ $flag -eq 0 ]
			then
				primo=1
			else
				primo=0
			fi
		fi
		i=`expr $i + 1`
	done
	if [ $primo -eq 0 ]
	then
		number=`expr $number + 1`
	else
		primeNumberCounter=`expr $primeNumberCounter + 1`
		echo $primeNumberCounter - $number
		number=`expr $number + 1`
		primo=0
	fi
	if [ $number -le 4 ]
	then
		echo "1 - 2"
		echo "2 - 3"
	fi
done


