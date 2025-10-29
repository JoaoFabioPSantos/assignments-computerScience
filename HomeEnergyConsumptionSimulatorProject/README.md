# Home Energy Consumption Simulator
Students:
- João Fabio Pereira dos Santos
- Mamdouh Alsaudi

## Description
A system that allows users to register household appliances in different residences and calculate monthly energy consumption based on usage time.

### Applied Concepts
- Classes: Appliance, Residence, MonthlyConsumption (ElectricGrid)
- Attribute encapsulation
- Methods for consumption calculation
## Classes and System Overview
Brief description of the system’s functionality.

### Main Class:
- Loop handling different system functions

### Electronic Appliance Class
1. Attributes: 
- ID (int)
- Name (string)
- Cost kWh (float)

2. Functions Controller: 
- *Register*
- *Remove*
- *List Eletronics*

### Residence Class
1. Attributes: 
- ID (int)
- Location/Name (string)
- Array Electronic Appliance(Eletronics[ ])

2. Functions Controller: 
- *Register Eletronic*
- *Set usage time for each Eletronics*
- *Register*
- *Remove*
- *List Residence*

### Electric Grid Class
1. Attributes:
- Array of residences (Residence[ ])
- Billing month (may vary depending on the number of days)

2. Functions:
- *Calculate residence cost (passing the residence ID, and returns the monthly cost)*

Note:
- In the monthly cost calculation, it is necessary to pass the month, the usage time of each appliance, and include all variables that affect the cost within the method. It is important to define these variables before starting the calculation.
