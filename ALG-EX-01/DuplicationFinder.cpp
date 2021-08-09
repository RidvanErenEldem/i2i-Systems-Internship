#include <bits/stdc++.h>

using namespace std;

void dupFinder(int *array, int size)
{
    //using a hash table to finding the impostor
    unordered_set<int> hashSet;
	unordered_set<int> duplicateSet;

    for(int i=0; i< size; i++)
    {
        if(hashSet.find(array[i]) == hashSet.end())
            hashSet.insert(array[i]);
        else
            duplicateSet.insert(array[i]);
    }

    cout << " tekrarlanan veriler: ";
    unordered_set<int> :: iterator itr;
    for(itr = duplicateSet.begin(); itr != duplicateSet.end(); itr++)
    {
        cout << *itr << " ";
    }
    cout << endl;
}

int main()
{
    int array[] = {1,2,4,8,3};
    int size = sizeof(array) / sizeof(array[0]);
    cout << "1. Dizide ";
    dupFinder(array,size);
    
    int array1[] = {4,6,12,5,5,89};
    int size1 = sizeof(array1) / sizeof(array1[0]);
    cout << "2. Dizide ";
    dupFinder(array1, size1);

    int array2[] = {4,3,8,8,35,35,12};
    int size2 = sizeof(array2) / sizeof(array2[0]);
    cout << "3. Dizide ";
    dupFinder(array2, size2);

    int array3[] = {5,5,78,6};
    int size3 = sizeof(array3) / sizeof(array3[0]);
    cout << "4. Dizide ";
    dupFinder(array3, size3);
    return 0;
}
