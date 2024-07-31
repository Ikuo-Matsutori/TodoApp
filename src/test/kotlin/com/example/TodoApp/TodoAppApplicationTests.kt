package com.example.TodoApp

import org.junit.jupiter.api.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//←ランダムなポートでテストを動かすため
class TodoAppApplicationTests (
	@Autowired val restTemplate: TestRestTemplate,//classのコンストラクターの省略形
	@LocalServerPort val port: Int
){

	@Test
	fun contextLoads() {
	}

	@Test
	fun `GETリクエストはOKステータスを返す`() {
		// localhost/todos に GETリクエストを発行する。ランダムポートに送ったリクエストを文字列で取得
		val response = restTemplate.getForEntity("http://localhost:$port/todos", String::class.java)
		// レスポンスのステータスコードは OK である。
		assertThat(response.statusCode, equalTo(HttpStatus.OK))
	}

	@Test
	fun `GETリクエストはTodoオブジェクトのリストを返す`() {
		// localhost/todos に GETリクエストを送り、レスポンスを Todoオブジェクトの配列として解釈する。
		val response: ResponseEntity<Array<Todo>> = restTemplate.getForEntity("http://localhost:$port/todos", Array<Todo>::class.java)
		// レスポンスの Content-Type は application/json であること。
		assertThat(response.headers.contentType, equalTo(MediaType.APPLICATION_JSON))
		// 配列は2つの要素をもつこと。
		val todos: Array<Todo> = response.body!!
		assertThat(todos.size, equalTo(2))
		// 最初の要素は id=1 であり、text が "foo" であること。
		assertThat(todos[0].id, equalTo(1))
		assertThat(todos[0].text, equalTo("foo"))
		// 次の要素は id=2 であり、text が "bar" であること。
		assertThat(todos[1].id, equalTo(2))
		assertThat(todos[1].text, equalTo("bar"))
	}
}
//クラスは誰も呼び出していながなぜ動くのか？必要な引数をSpringが勝手に検出して注入してくれる。これが依存注入。
//port= random()
//server =new TomcatServer(port)
//testTemplate =new Test TestTemplate(server)
//testapp =new TodoAppApplicationTest(restTemplate,port)
//testapp.GETリクエストはOKステータスを返す()