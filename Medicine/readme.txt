Use Postman as api endpoint

GetMedicines-> on url localhost:8080/medicines (retrieves list of all medicines)
GetMedicines by Id-> on url localhost:8080/medicines/get/id/#medsId#
GetMedicines by name-> on url localhost:8080/medicines/get/name/#medsName#
GetMedicines by category-> on url localhost:8080/medicines/get/category/#category#


SaveMedicines-> on url localhost:8080/save (creates/saves a new user)


UpdateMedicine-> on url localhost:8080/update/xx  xx id number of medicine you want to update
ex: localhost:8080/update/6 updates med with id 6


DeleteMediccine-> on url localhost:8080/delete/xx id number of medicine you want to update
ex: localhost:8080/delete/5 deletes med with id 5


For weekly plans:

to create a plan(all required medicines must exist) -> http://localhost:8081/plan/save
in the following format:
[
{
        "planDate": "yyyy-mm-dd",    can't be a past date, and the last date has a limit of 7 days counting from this one
        "weekday": "weekday",
        "plans": {
            "planId": #planId#                 has to be the same in every day, only possible to add one plan at a time
        },
        "meds": {
            "medsId":#medsId#              medsId of the wanted medicine
        },
        "medsToTake": #number of pills to take#
    },{
        "planDate": "yyyy-mm-dd",
        "weekday": "weekday",
        "plans": {
            "planId": ##
        },
        "meds": {
            "medsId": ##
        },
        "medsToTake": ##
    }
...
]


To delete plans-> localhost:8081/plans/delete/#planId# (id of the plan you wish to delete)

To get Plans by id: localhost:8081/plans/get/id/#planId# (id of the plan you wish to see)
To get Plans by medsCategory:localhost:8081/medicines/get/category/#category# (category of the meds in the plan you wish to see)







