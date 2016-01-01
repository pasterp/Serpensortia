#!/bin/sh

mkdir out
for f in *.png; do
    convert ./"$f" -resize 32x32\! ./out/"${f}"
done
