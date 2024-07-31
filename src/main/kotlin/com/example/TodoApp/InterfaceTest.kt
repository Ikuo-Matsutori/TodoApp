package com.example.TodoApp

interface Database {
    fun getData(): String
    fun setData(data: String)
}

//interface Database {
//    getData(): string
//    setData(data: string): void
//}

class DummyDatabase1: Database {
    override fun getData(): String {
        return "bla"
    }
    override fun setData(data:String){}
}

class DummyDatabase2: Database {
    private var mydata: String = ""

    override fun setData(data: String) {
        this.mydata = data
    }

    override fun getData(): String {
        return this.mydata
    }
}

class RealDatabase: Database {
    override fun setData(data: String) {
        ///???
    }

    override fun getData(): String {
        return ""
    }
}

fun useDatabase(somethingDatabase: Database) {
    //val somethingDatabase: Database = DummyDatabase2()
    somethingDatabase.getData()
    somethingDatabase.setData("test")
}


