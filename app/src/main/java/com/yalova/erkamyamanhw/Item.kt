package com.yalova.erkamyamanhw

open class Item( val name: String,  val price: Double) {
}


class Food( weight: String,name: String,  price: Double): Item(name, price) {

}

class Cloth( type: String,name: String,  price: Double): Item(name, price) {

}

class ShoppingList(){
     val items = ArrayList<Item>()

    fun addItem(type:Int){
        var name = ""
        var price: Double? = null
        if (type==1){

            println("Enter name:")
            name = readLine().toString()

            while (price == null) {
                println("Enter price:")
                price = readLine()?.toDoubleOrNull()

                if (price == null) {
                    println("Invalid price. Please enter a valid number.")
                }
            }

            println("Enter weight:")
            val weight = readLine().toString()

            val item = Food(weight,name, price)
            items.add(item)
            println("$name  is succesfully added")
        }else if(type==2){
            println("Enter name:")
            name = readLine().toString()

            while (price == null) {
                println("Enter price:")
                price = readLine()?.toDoubleOrNull()

                if (price == null) {
                    println("Invalid price. Please enter a valid number.")
                }
            }

            println("Enter type:")
            val type = readLine().toString()

            val item = Cloth(type,name, price)
            items.add(item)
            println("$name is succesfully added")
        }

    }

    fun deleteItem(num: Int){

           val deletedItemName = items[num-1].name
            items.removeAt(num-1)
        println("$deletedItemName is succesfully deleted!")


    }

    fun displayItem(){
        for ((index,item) in items.withIndex()) {
            item.let {
                println("${index + 1} - ${it.name} - $${it.price}")
            }
        }
    }
    }



fun main (){
    var isCompleted = false
    var option: Int

    val defo  = ShoppingList()
    while (!isCompleted) {
        println("Menu:")
        println("1. Add Item")
        println("2. Display Item")
        println("3. Delete Item")
        println("4. Exit")
        print("Enter your choice: ")
        option = readLine()?.toIntOrNull() ?: 0


        when (option) {
            1 -> {
                do {
                println("1. Add Food")
                println("2. Add Cloth")
                print("Enter your choice: ")
                val subChoice = readLine()?.toIntOrNull() ?: 0
                when (subChoice) {
                    1 -> defo.addItem(subChoice)
                    2 -> defo.addItem(subChoice)
                    else -> println("Invalid choice")
                }} while (subChoice !in 1..2)


            }
            2 -> {
                if (defo.items.isEmpty()){
                    println("The list is empty!")
                }else{
                    defo.displayItem()
                }

            }
            3 -> {
                if (defo.items.isEmpty()){
                    println("The list is empty!")
                }else{
                    val subChoice = readLine()?.toIntOrNull() ?: 0
                    defo.deleteItem(subChoice)
                }

            }
            4 -> {
                println("Exiting program...")
                isCompleted = true
            }
            else -> println("Invalid option")
        }
    }
}