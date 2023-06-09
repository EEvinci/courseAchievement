# Docker-Learning

## docker的使用大致过程

对自己的应用通过docker（核心是docker file）进行镜像的打包，然后分享到docker hub可以使得社区中的人都对你的应用进行拉取，然后可以在不同的设备上对该镜像创建容器，顺利运行该程序
在该过程中无需考虑运行环境的不同和缺失依赖的问题，因为这些在镜像中已经全部包含了，只需要将目标应用的镜像拉取下来，然后在本地创建运行该实例的一个容器即可

> **容器（container）**：每个容器都是一个隔离的环境，其中可以运行应用及其依赖，而这个环境与宿主机系统和其他容器是隔离的。
>
> **镜像（Image）：**镜像是一个**只读的模板**，包含了**运行应用所需的代码、库、环境变量和配置文件**。你可以**从镜像创建新的容器**，也可以创建新的镜像并分享给他人。
>
> 是一个静态的、只读的模板，包含了运行应用所需的代码、库、环境变量和配置文件。**镜像通常基于其他镜像创建**，添加一些额外的自定义设置。你可以把镜像理解为应用的“蓝图”。

同时一个镜像可以创建多个容器，从而满足不同的场景需要

一个镜像可以理解成为面向对象中的一个类，而容器可以理解成为该类创建的对象





## 一个镜像中包含的内容

通常一个镜像包含一个基础镜像和一个dockerfile



## 在springboot项目中和传统的maven打包分发部署的差别





## 自动测试自动部署工具



## 对于docker的理解层次

对于 Docker 的充分理解，你需要了解以下内容：

- Docker 的核心概念，包括镜像、容器、Dockerfile、卷（Volume）、网络等。
- Docker 的基本操作，包括创建和运行容器、管理镜像和容器、使用 Dockerfile 创建镜像等。
- Docker 的原理，包括容器化技术、镜像层、容器层、namespaces、cgroups 等。
- Docker 的应用场景，包括微服务、DevOps、Continuous Delivery、应用的打包和分发等。
- Docker 的生态系统，包括 Docker Hub、Docker Compose、Kubernetes 等。