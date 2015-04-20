#!/usr/bin/env bash

# b means "build" if you pass this option to script such maven
# commands as "clean" "package" and "assembly" will be invoked
while getopts ":b" opt; do
  case $opt in
    b)
      mvn clean package assembly:single >&2
      ;;
    \?)
      echo "Invalid option!" >&2
      exit 1
      ;;
  esac
done

echo "Please enter search string:"
read sdata
echo "Waiting for result titles..."
java -jar target/SLoader-exec.jar ${sdata}
echo "end."