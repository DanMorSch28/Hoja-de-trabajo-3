/*
 Daniel Morales 15526
 Fernando Hernandez 
 Rodrigo Corona 15102
 */
 
import java.util.ArrayList;
import java.util.Comparator;

public final class Sorts {

    public static void InsertionSort(Comparable[] lista) throws IllegalArgumentException{

        if(lista instanceof Integer[]){
            // Calcular el numero mayor.
            Integer mayor = (Integer) lista[0];
            int n = lista.length;
            for (int i = 0; i < n; i++){
                if ((Integer)lista[i] > mayor){
                    mayor = (Integer)lista[i];
                }
            }
            int[] temporal = new int[n];

            // Divisior para ir obteniendo los enteros mas significativos.

            // Variable de digito significativo
            int digitosign = 0;

            // Empezar a realizar el sort hasta, que se alcance el digito mas significativo
            for (int divisor = 1; mayor / divisor > 0; divisor *=10) {
                // Crear array de soporte
                int[] supp = new int[10];

                // Contar los digitos significativos en el array de soporte
                for (int i = 0; i < n; i++) {
                    digitosign = ((Integer) lista[i] / divisor) % 10;
                    supp[digitosign] += 1;
                }

                // Sumar posiciones al array de soporte
                for (int i = 0; i < 9; i++) {
                    supp[i + 1] += supp[i];
                }

                // Aniadir los elementos al array temporal
                for (int i = n - 1; i >= 0; i--) {
                    digitosign = supp[((Integer) lista[i] / divisor) % 10] -= 1;
                    temporal[digitosign] = (Integer) lista[i];
                }

                // Regresar los elementos operados al array normal
                for (int i = 0; i < n; i++) {
                    lista[i] = temporal[i];
                }
            }
        }else{
            throw new IllegalArgumentException();
        }


    }
        
    public static void mergeSort(Comparable[] vector)
	{
		Comparable[] temporal = new Comparable[vector.length];
		mergeSort(vector, temporal,  0,  vector.length - 1);
	}
    
    private static void mergeSort(Comparable[] vector, Comparable[] temporal, int izquierda, int derecha)
	{
		if( izquierda < derecha )
		{
			int centro = (izquierda + derecha) / 2;
			mergeSort(vector, temporal, izquierda, centro);
			mergeSort(vector, temporal, centro + 1, derecha);
			merge(vector, temporal, izquierda, centro + 1, derecha);
			
		}
	}
    
    private static void merge(Comparable[] vector, Comparable[] temporal, int izquierda, int derecha, int finDerecha )
    {
        int finIzquierda = derecha - 1;
        int n = izquierda;
        int num = finDerecha - izquierda + 1;

        while(izquierda <= finIzquierda && derecha <= finDerecha)
            if(vector[izquierda].compareTo(vector[derecha]) <= 0)
                temporal[n++] = vector[izquierda++];
            else
                temporal[n++] = vector[derecha++];

        while(izquierda <= finIzquierda)    // Copia el resto de la primera mitad
            temporal[n++] = vector[izquierda++];

        while(derecha <= finDerecha)  // Copia el resto de la segunda mitad
            temporal[n++] = vector[derecha++];

        // Copia temporal otra vez
        for(int i = 0; i < num; i++, finDerecha--)
            vector[finDerecha] = temporal[finDerecha];
        
        
    }
    public static void quickSort(Comparable[] vector, int izquierda, int derecha){

    	
    	if(vector == null || vector.length ==0){
    		return;
    	/*Si el vector esta vacio, el arreglo ya esta ordenado*/
    	}
    	if(izquierda >= derecha){
    		return;
    	/*Si el indice menor es mayor o igual que el indice mayor de la derecha*/
    	/* quiere decir que es un arreglo de un unico elemento, por tanto, ya esta arreglado*/
    	}
    	
    	/*Elegir un pivote*/
    	int medio = izquierda + (derecha-izquierda)/2;
    	Integer pivote = (Integer)vector[medio];
    	
    	int i = izquierda, j = derecha;
    	while (i <=j){
   
    		/*Envia a la derecha a los numeros mayores al pivote y a la izquierda a los menores*/

    		while((Integer)vector[i] < pivote){
    			i++;
    		}
    		while((Integer)vector[j]> pivote){
    			j--; 
    		}
    		
    		if(i <=j){
    			int temp = (Integer)vector[i];
    			vector[i] = vector[j];
    			vector[j] = temp; 
    			i++; 
    			j--;

    		}
    	}
    	
    	/*Utiliza recursion para llamar a los dos subarreglos creados por la division de los menores y los mayores 
    	 * al pivote original*/
    	if (izquierda < j){
    		quickSort(vector, izquierda, j);
    	}
    	if (derecha > i){
    		quickSort(vector, i, derecha);
    	}
    	
    }

	public static void BubbleSort (Comparable NodoDoble lis) //Lista de nodos
   {
      int min;	//Cabeza
      Comparable temp;	//valor

      for (int index = 0; index < list.length-1; index++) //Mientras el nodo siguiente no sea null
      {
         min = index; //Cabeza noda actual
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0)
               min = scan;

         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }            
   }

}
