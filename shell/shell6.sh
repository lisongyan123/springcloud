#!/usr/bin/env bash
echo `date +%W`
echo `date +%U`
echo `date +%V`

exit 0

# %W是以星期一为一个周的第一天，
# %U是以星期天为一个周的第一天，
# %V是ISO的周表示方法，也是以星期一为一个周的第一天，不同的是，他没有第0个周的概念。