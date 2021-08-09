# log4j edit with vi

commands:
  vi filename --> opens file
  after file openned pressing "i" key enters the instert mode
  for saving the file press esc to enter command mode then write :wq

replace command:
  vi -c "%s/INFO/DEBUG/g|wq" log4j.xml
