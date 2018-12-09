# chicago-311-service-requests
Provides **a way to manage** (create/read/update/delete) **Chicago 311 Service Requests**, as those are described [here](https://www.kaggle.com/chicago/chicago-311-service-requests)

## Setup

### Database
* Create a schema named `chicago_service_requests` under postgres database
* Just run the app and hibernate with flyway should do the rest for some basic sample data

### Loading Data
* Change `csr.csv.files.base.folder` in application.properties to point to the base folder that contains the .csv files
* Send a **GET** request to the URI `/load-service-requests/{csvFileName}` where `csvFileName` stands for the name of the csv file that you want to parse and load. 
For example `http://localhost:8080/load-service-requests/311-service-requests-alley-lights-out` will load all the data contained in the 311-service-requests-alley-lights-out.csv file
* The procedure is asynchronous (but only one can be performed at a time)