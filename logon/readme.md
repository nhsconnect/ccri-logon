
# Docker Notes

Which starts the app within your browser.




In this directory

docker build . -t ccri-logon

docker tag ccri-logon thorlogic/ccri-logon

docker push thorlogic/ccri-logon

docker run -d -p 4200:4200 ccri-logon 

