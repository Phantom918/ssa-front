## spring-cloud-alibaba 整合 Spring Authorization Server

### 微服务模块说明

**auth**: 作为登录授权下发token的服务，使用最新的Spring Authorization Server 1.0.1实现。

**gateway**: 作为访问其它微服务的网关，认证和鉴权在这里作为总入口，其它实际业务的服务模块就不用再关注认证和鉴权的，统一由网关来实现，使用Spring Cloud Gateway实现。

**provider**: 作为实际业务模块的服务，使用Spring Cloud Alibaba实现。

## 其它

### swagger2 与 swagger3 的标签注解对应关系

在swagger2中SpringFox项目使用非常广泛，它也是让spring boot项目快速的集成swagger。目前此项目已经停止更新。那么他们直接注解的对应关系如下：

```java
@Api → @Tag

@ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden

@ApiImplicitParam → @Parameter

@ApiImplicitParams → @Parameters

@ApiModel → @Schema

@ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)

@ApiModelProperty → @Schema

@ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")

@ApiParam → @Parameter

@ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")

```
