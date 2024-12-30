# API 文档

## 目录
- [通用说明](#通用说明)
- [用户接口列表](#用户接口列表)
- [管理员接口列表](#管理员接口列表)
- [错误码说明](#错误码说明)

## 通用说明

### 基础URL
```
http://localhost:8088
```

### 请求格式
- 所有接口只支持 HTTP POST 方法，不支持GET请求
- 请求头必须包含：
```
Content-Type: application/json
Authorization: Bearer {token}  // 除登录/注册外的接口都需要
```

### 通用响应格式
```json
{
    "code": 0,           // 状态码，0表示成功
    "message": "成功",    // 状态信息
    "data": {}           // 响应数据
}
```

## 用户接口列表

### 1. 用户登录
**POST** `/api/login`

**请求参数**
```json
{
    "username": "string",    // 用户名
    "password": "string"     // 密码
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "token": "eyJhbGciOiJIUzI1NiIs...",
        "userId": "12345",
        "username": "张三"
    }
}
```

### 2. 用户注册
**POST** `/api/register`

**请求参数**
```json
{
    "username": "string",    // 用户名
    "password": "string",    // 密码
    "email": "string",      // 邮箱
    "phone": "string"       // 手机号
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "userId": "12345",
        "username": "张三"
    }
}
```

### 3. 获取用户信息
**POST** `/api/info`

**请求参数**
```json
{
    "userId": "string"    // 用户ID
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "userId": "12345",
        "username": "张三",
        "email": "zhangsan@example.com",
        "phone": "13800138000",
        "createTime": "2024-03-20 12:00:00"
    }
}
```

## 管理员接口列表

### 1. 管理员登录
**POST** `/api/admin/login`

**请求参数**
```json
{
    "username": "string",    // 管理员用户名
    "password": "string"     // 密码
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "token": "eyJhbGciOiJIUzI1NiIs...",
        "adminId": "admin123",
        "username": "admin"
    }
}
```

### 2. 获取用户列表
**POST** `/api/admin/userList`

**请求参数**
```json
{
    "page": 1,           // 页码
    "pageSize": 10,      // 每页数量
    "searchKey": ""      // 搜索关键词（可选）
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": {
        "total": 100,
        "list": [
            {
                "userId": "12345",
                "username": "张三",
                "email": "zhangsan@example.com",
                "phone": "13800138000",
                "createTime": "2024-03-20 12:00:00",
                "status": 1    // 1:正常 0:禁用
            }
            // ...
        ]
    }
}
```

### 3. 禁用/启用用户
**POST** `/api/admin/updateUserStatus`

**请求参数**
```json
{
    "userId": "string",    // 用户ID
    "status": 0           // 状态 1:正常 0:禁用
}
```

**响应示例**
```json
{
    "code": 0,
    "message": "成功",
    "data": null
}
```

## 错误码说明

| 错误码 | 说明 |
|--------|------|
| 0 | 成功 |
| 1001 | 用户名或密码错误 |
| 1002 | 用户已存在 |
| 1003 | 参数错误 |
| 1004 | token无效或已过期 |
| 1005 | 无权限访问 |
| 2001 | 服务器内部错误 |

## 注意事项
1. 所有请求参数均为必填，除非特别说明
2. token有效期为24小时
3. 密码传输前需进行MD5加密
4. 时间格式统一使用：YYYY-MM-DD HH:mm:ss
5. 管理员接口需要管理员权限的token


