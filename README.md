# chicago-311-service-requests
Provides **a way to manage** (create/read/update/delete) **Chicago 311 Service Requests**, as those are described [here](https://www.kaggle.com/chicago/chicago-311-service-requests)

## Setup
### Database
* Create a schema named `chicago_service_requests` under postgres database
* Just run the app and hibernate with flyway should do the rest for some basic sample data

### Loading Data
* Change `csr.csv.files.base.folder` in application.properties to point to the base folder of your machine that will contain the .csv files to load the data from
* Send a **GET** request to the URI `/load-service-requests/{service-request-type-and-csv-file-name}` where `service-request-type-and-csv-file-name` stands for the name of the csv file that you want to parse and load, 
as well as for the service request type of the service request. 
It can be one of the following:
* abandoned-vehicles
* garbage-carts
* rodent-baiting
* pot-holes
* graffiti-removal
* tree-debris
* tree-trims
* sanitation-code
* general -- For .csv files that have the minimum amount of columns (15) you can use whatever name you want. Sample .csv files can be found and loaded under the resources folder.