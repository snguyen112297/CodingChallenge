import org.omg.CORBA.Current

fun reverseString(input: String): String{
    var output: String = ""
    for (i in input.length-1 downTo 0){
        output += input[i]
    }
    return output
}

fun findMax(input: Array<Int>): Int{
    var output: Int = input[0]
    for (i in 0..input.size-1){
        if (output < input[i]){
            output = input[i]
        }
    }
    return output
}

interface Bank{
    fun deposit(input: Int)
    fun withdraw(input: Int)
}

class SavingAccount:Bank{
    var balance: Int = 0
    override fun deposit(input: Int){
        if (input >= 0){
            balance += input
        }
        else {
            this.withdraw(-input)
        }
    }
    override fun withdraw(input: Int) {
        if (input <= 0){
            this.deposit(-input)
        }
        else {
            if (input > balance){
                println("Insufficient fund")
            }
            else{
                balance -= input
            }
        }
    }

    fun display(){
        println(this.balance.toString())
    }
}

class CurrentAccount:Bank{
    var balance: Int = 0
    override fun deposit(input: Int){
        if (input >= 0){
            balance += input
        }
        else {
            this.withdraw(-input)
        }
    }
    override fun withdraw(input: Int) {
        if (input <= 0){
            this.deposit(-input)
        }
        else {
            if (input+100 > balance){
                println("Insufficient fund")
            }
            else{
                balance -= input
            }
        }
    }

    fun display(){
        println(this.balance.toString())
    }
}

fun main(){
    // Reverse a string
    println(reverseString("alo"))


    // Find the maximum number in an array of integers
    val myArray = arrayOf(-6, 5, 3, 8, 9)
    println(findMax(myArray))


    // Create a SavingAccount. Accept negative values. Print out notice
    // about insufficient funding if Son is poorer than he thinks.
    var sonsSaving = SavingAccount()
    sonsSaving.display()
        // Deposit 500. Total 500
    sonsSaving.deposit(500)
        // Deposit 500. Total 1000
    sonsSaving.withdraw(-500)
    sonsSaving.display()
        // Deposit 1500. Total 2500
    sonsSaving.deposit(1500)
        // Withdraw 2000. Total 500
    sonsSaving.withdraw(2000)
    sonsSaving.display()
        // Withdraw 2000. Invalid
    sonsSaving.withdraw(2000)


    // Create a CurrentAccount. Accept negative values. Print out notice
    // about insufficient funding if Son need to cancel his Netflix.
    var sonsChecking = CurrentAccount()
    sonsChecking.display()
        // Deposit 1000. Total 1000
    sonsChecking.withdraw(-1000)
        // Withdraw 500. Total 500
    sonsChecking.withdraw(500)
        // Deposit 600. Total 1100
    sonsChecking.withdraw(-600)
        // Deposit 50. Total 1150
    sonsChecking.deposit(50)
    sonsChecking.display()
        // Withdraw 1050. Total 100
    sonsChecking.withdraw(1050)
    sonsChecking.display()
        // Deposit 1050. Total 1150
    sonsChecking.deposit(1050)
        // Withdraw 1051. Invalid
    sonsChecking.withdraw(1051)
}
