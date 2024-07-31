
class User {
    id: number
    name: string

    show() {
        console.log(`name: ${this.name}`)
    }
}

const user1 = new User()
user1.id = 123
user1.name = "abc"
user1.show()
const user2 = new User()
user2.id = 444
user2.name = "xyz"
user2.show()
