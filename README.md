# API 文档

## 目录
- [通用说明](#通用说明)
- [接口列表](#接口列表)
- [错误码说明](#错误码说明)

## 通用说明

### 基础URL
```
https://api.example.com
```

### 请求格式
- 所有请求都使用 HTTPS POST 方法
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

## 接口列表

### 1. 用户登录
**POST** `/api/auth/login`

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
**POST** `/api/auth/register`

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
**POST** `/api/user/info`

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


