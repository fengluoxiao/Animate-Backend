# API 文档

## 目录
- [客户端接口](#客户端接口)
- [管理端接口](#管理端接口)

## 客户端接口
基础URL: `http://localhost:8086/api`

### 1. 测试接口
**GET** `/test`

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": "Hello World!"
}
```

### 2. 获取所有名称
**GET** `/getallname`

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": [
        {
            "id": 1,
            "name": "测试名称1"
        },
        {
            "id": 2,
            "name": "测试名称2"
        }
    ]
}
```

### 3. 获取指定名称
**GET** `/getname/{id}`

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 1,
        "name": "测试名称1"
    }
}
```

### 4. 创建名称
**POST** `/createname`

**请求参数**
```json
{
    "name": "新名称"
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 3,
        "name": "新名称"
    }
}
```

### 5. 更新名称
**PUT** `/updatename/{id}`

**请求参数**
```json
{
    "name": "更新的名称"
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": {
        "id": 1,
        "name": "更新的名称"
    }
}
```

### 6. 删除名称
**DELETE** `/deletename/{id}`

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": null
}
```

## 管理端接口
基础URL: `http://localhost:8088/api/admin`

### 1. 管理员登录
**POST** `/login`

**请求参数**
```json
{
    "username": "string",
    "password": "string"
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": "eyJhbGciOiJIUzI1NiIs..."  // JWT token
}
```

### 2. 管理员注册
**POST** `/register`

**请求参数**
```json
{
    "username": "string",
    "password": "string"
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": "Admin created successfully"
}
```

### 3. 获取仪表盘数据
**GET** `/dashboard`

**请求头**
```
Authorization: Bearer {token}
```

**响应示例**
```json
{
    "code": 0,
    "message": "success",
    "data": {
        "totalUsers": 100,
        "totalOrders": 50,
        "revenue": 10000
    }
}
```

## 错误响应
当发生错误时，响应格式如下：
```json
{
    "code": 1,
    "message": "错误信息",
    "data": null
}
```

## 注意事项
1. 所有请求的响应都使用统一的 ApiResponse 格式
2. 管理端接口需要在请求头中携带 JWT token（登录和注册接口除外）
3. 客户端接口运行在8086端口，管理端接口运行在8088端口


