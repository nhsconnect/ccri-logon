# DocumentReviewApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.6.4.
Install angular: Follow step 1 from https://angular.io/guide/quickstart

Other steps 

npm install --save @angular-devkit/core

npm install -g ajv@^6.0.0

npm install --save @types/fhir


## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

##Docker 


docker build . -t thorlogic/ccri-cat

docker tag thorlogic/ccri-cat thorlogic/ccri-cat:latest

docker push thorlogic/ccri-cat

###Local test 

docker run -d -p 4200:80 --name ccri-app thorlogic/ccri-cat 

### Docker clean up

docker rm $(docker ps -q -f 'status=exited')
docker rmi $(docker images -q -f "dangling=true")