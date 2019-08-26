!#/bin/sh
echo "Insira um numero: "
read numero1
echo "Insira um numero: "
read numero2
echo "Insira um numero: "
read numero3

if [ $numero1 -le $numero2 -a $numero1 -le $numero3 ]
then
	echo $numero1 "-"
	 if [ $numero2 -le $numero3 ]
        then
                echo $numero2 "-" $numero3
        else
                echo $numero3 "-" $numero2
        fi

else 
	if [ $numero2 -le $numero3 ]
	then
		echo $numero2 "-" $numero3
	else
		echo $numero3 "-" $numero2
	fi
	echo "-" $numero1
fi
