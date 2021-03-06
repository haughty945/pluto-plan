## 介绍 

    OAuth 2.0是用于授权的行业标准协议。OAuth 2.0取代了在2006年创建的原始OAuth协议上所做的工作。OAuth 2.0专注于客户端开发人员的简单性，同时为Web应用程序，桌面应用程序，手机和客厅设备提供特定的授权流程。

    在目前的系统中，各系统用户需要访问系统内的资源时，一般需要凭用户名和密码登录系统后才能访问，这时各系统自己存储和管理用户的用户名和密码，就会出现文章之初出现的问题（实际问题可能会有其他情况），而使用OAuth,用户的账号密码存储在身份认证中心，可以有效避免此类问题的产生。
    
## 角色

    OAuth定义了四种角色：
    
    -- 资源所有者
        
        能够许可对受保护资源的访问权限的实体。当资源所有者是个人时，它被称为最终用户。
    
    -- 资源服务器
        
        托管受保护资源的服务器，能够接收和响应使用访问令牌对受保护资源的请求。
    -- 客户端
        
        使用资源所有者的授权代表资源所有者发起对受保护资源的请求的应用程序。术语“客户端”并非特指任何特定的的实现特点（例如：应用程序是否是在服务器、台式机或其他设备上执行）。
        
    -- 授权服务器
        在成功验证资源所有者且获得授权后颁发访问令牌给客户端的服务器。
        
        授权服务器和资源服务器之间的交互超出了本规范的范围。授权服务器可以和资源服务器是同一台服务器，也可以是分离的个体。一个授权服务器可以颁发被多个资源服务器接受的访问令牌