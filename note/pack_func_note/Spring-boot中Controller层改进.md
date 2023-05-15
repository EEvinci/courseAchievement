# Controller层改进

## 首先controller调用的是service层的接口

repository负责访问数据库，以实现相应的数据库操作CRUD等

service层中的impl包调用repository层的接口访问数据库进行操作以实现核心的业务逻辑，将结果返回给controller

controller接受来自用户的请求，并处理用户输入的参数，然后调用service层的业务处理代码对实现需求，最后返回给客户端

## controller层在对用户发起的请求进行处理时应该进行检查

应该**提前考虑到某些可能出现的错误的情况**，并**给出适当的错误信息**

如当用户对一个**不存在的课程的编号**进行查询请求时，此时应该返回的是一个**错误的信息**，而**不是一个空的课程对象**

即信息应该进行封装，**严格区分什么是正常的信息，什么是不正常的信息**

当**用户行为出现在程序允许的范围之外**，应该提醒并提示错误，**明确的告诉用户该操作的错误性**；而**不是以一种不显示资源的方式让用户产生疑惑**

## controller中的API设计应该遵循RESTful风格

(uniform resource identifier)**URI 统一资源标识符**

URI表示的应该是**资源**

而HTTP方法(例如GET POST PUT DELETE)表示**对资源的操作**, **是动词**

所以在RestMapping和GetMapping/PostMapping/PutMapping/DeleteMapping中的URI表示应该**都是名词**

@GetMapping("")