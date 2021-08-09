# log4j edit with vi

commands:<br>
<space><space><space>vi filename --> opens file<br>
<space><space><space>after file openned pressing "i" key enters the instert mode<br>
<space><space><space>for saving the file press esc to enter command mode then write :wq<br>

replace command:<br>
<space><space><space>vi -c "%s/INFO/DEBUG/g|wq" log4j.xml
