Direct Adress Hash Table

Authors:
    Henri

Acknowledgments: 
    Mr.Kuszmaul

List of methods:\
___DAHT:\
______DAHT()\
______int[] ht\
__________ht is the hash table array it has a length of 100\
______void insert(Data x)\
__________Inserts Data objects at the index of the hashed data.key\
______Data delete(Data x)\
__________Finds the presented datapoint in the Hash Table and switches it out for null\
______Data search(int key)\
__________returns Data object for requested key integer\
______int hash(int key)\
__________Returns a hash, current set to be direct

___Data:\
______Data(int value, int key)\
______String toString()