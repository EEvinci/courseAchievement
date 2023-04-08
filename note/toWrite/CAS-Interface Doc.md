# CAS-Interface Doc

## course

### query course

调用本接口查询指定编号的课程。

#### 接口**URL**

`http://localhost:8080/course/queryCourseByNum/222`

#### 请求方式

`GET`

#### Body参数

|   名称    |  类型  | 是否必填 |   描述   |
| :-------: | :----: | :------: | :------: |
| courseNum | String |    是    | 课程编号 |

#### 返回参数

|   名称    |  类型  |          描述          |
| :-------: | :----: | :--------------------: |
| courseNum | String | 返回当前提交的课程信息 |



### delete course

调用本接口删除指定编号的课程。

#### 接口**URL**

`http://localhost:8080/course/deleteCourse/A1010`

#### 请求方式

`DELETE`

#### Body参数

|   名称    |  类型  | 是否必填 |   描述   |
| :-------: | :----: | :------: | :------: |
| courseNum | String |    是    | 课程编号 |

#### 返回参数

|   名称    |  类型  |                    描述                    |
| :-------: | :----: | :----------------------------------------: |
| courseNum | String | 返回 "已删除编号为" + courseNum + "的课程" |

### update course

调用本接口更新课程信息。

#### 接口**URL**

`http://localhost:8080/course/updateCourse/2002/PLC/Good/goodBook/CS/GM`

#### 请求方式

`POST`

#### **Body**参数

|     名称      |  类型  | 是否必填 |   描述   |
| :-----------: | :----: | :------: | :------: |
|   courseNum   | String |    是    | 课程编号 |
|  courseName   | String |    是    | 课程名称 |
|  courseDesc   | String |    是    | 课程描述 |
|   textBook    | String |    是    |   教材   |
|  courseLabel  | String |    是    | 课程标签 |
| courseTeacher | String |    是    | 授课老师 |

#### 返回参数

|  名称  |  类型  |          描述          |
| :----: | :----: | :--------------------: |
| course | String | 返回当前提交的课程信息 |

### add course

调用本接口添加课程信息。

#### 接口**URL**

`http://localhost:8080/course/addCourse/2002/PLC/GoodCourse/GoodBook/CS/GM`

#### 请求方式

`PUT`

#### Body参数

|     名称      |  类型  | 是否必填 |   描述   |
| :-----------: | :----: | :------: | :------: |
|   courseNum   | String |    是    | 课程编号 |
|  courseName   | String |    是    | 课程名称 |
|  courseDesc   | String |    是    | 课程描述 |
|   textBook    | String |    是    |   教材   |
|  courseLabel  | String |    是    | 课程标签 |
| courseTeacher | String |    是    | 授课老师 |

#### 返回参数

|   名称    |  类型  |          描述          |
| :-------: | :----: | :--------------------: |
| courseNum | String | 返回当前提交的课程信息 |