## Commit Message Format

以下是对于 Git commit messagee 的精确规则，这种格式使得提交的历史记录更易于我们阅读

每一个 commit message 都由 **header**,  **body**, 和 **footer** 三个部分组成：


``` 
<header>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

- `header` 是必需的，并且必须符合 [Commit Message Header ](#commit-header)格式

- 除了 `type` 为 `docs` 之外，所有的 commits 都必须使用 `body` ，当 `body` 存在时，其长度至少为 20 个字符，并且必须符合[Commit Message Body](#commit-body) 格式

- `footer`是可选的，[Commit Message Footer](#commit-footer) 描述了 `footer` 的用途及其必须具有的结构


#### <a name="commit-header">Commit Message Header</a>

```
<type>(<scope>): <short summary>
  │       │             │
  │       │             └─⫸ 使用第一人称现在时态总结；不用大写；末尾没有句号；
  │       │
  │       └─⫸ Commit Scope: animations|bazel|benchpress|common|compiler|compiler-cli|core|
  │                          elements|forms|http|language-service|localize|platform-browser|
  │                          platform-browser-dynamic|platform-server|router|service-worker|
  │                          upgrade|zone.js|packaging|changelog|docs-infra|migrations|ngcc|ve
  │
  └─⫸ Commit Type: build|ci|docs|feat|fix|perf|refactor|test
```

`<type>` 和 `<summary>` 部分是强制必须的，  `(<scope>)` 部分是可选的


##### Type 【必选】

必须是以下之一：

* **feat**：增加新功能
* **fix**：修复 bug
* **docs**：仅文档出现变动
* **style**：格式变动（不影响代码运行的变动，例如空格缩进，代码格式化）
* **refactor**：重构（既不是增加新功能的代码更改，也不是修复 bug 的代码更改）
* **perf**：提高系统性能的代码更改
* **test**：增加缺失的测试或者更改现有的测试
* **build**：影响构建系统或者外部依赖项
* **ci**：CI、配置文件或脚本出现变动
* **chore**：不影响 src 和 test 文件的其他代码更改
* **revert**：撤销以前的一个 commit


##### Scope【可选】
scope 用于说明 commit 影响的范围，后端可以是比如数据层、控制层、视图层等等，前端项目可以是受影响的 NPM 包的名称，具体情况视项目的不同而不同。

以下是前端项目受支持的范围：

* `animations`
* `bazel`
* `benchpress`
* `common`
* `compiler`
* `compiler-cli`
* `core`
* `elements`
* `forms`
* `http`
* `language-service`
* `localize`
* `platform-browser`
* `platform-browser-dynamic`
* `platform-server`
* `router`
* `service-worker`
* `upgrade`
* `zone.js`


##### Summary 【必选】

使用 Summary 字段来提供更改的简明描述：

* 以动词开头，使用第一人称现在时态，例如：应该使用 "change" 而不是 "changed" 或者 "changes"
* 首字母不需要大写
* 结尾不要使用句号


#### <a name="commit-body">Commit Message Body</a>

- 正如在 **Summary** 部分一样，需要使用第一人称现在时态，例如：应该使用 "fix" 而不是 "fixed" 或者 "fixes"

- 解释更改的动机，这条 commit message 应该能够解释你为什么要做此次更改
- 你可以将以前的代码与更改之后的代码进行比较，以说明更改的影响


#### <a name="commit-footer">Commit Message Footer</a>

`footer` 部分包含关于不兼容的变动和弃用的信息，同时也是关闭和这个 commit 相关的 issues、pr 的地方

例如：

```
BREAKING CHANGE: <breaking change summary>
<BLANK LINE>
<breaking change description + migration instructions>
<BLANK LINE>
<BLANK LINE>
Fixes #<issue number>
```

or

```
DEPRECATED: <what is deprecated>
<BLANK LINE>
<deprecation description + recommended update path>
<BLANK LINE>
<BLANK LINE>
Closes #<pr number>
```

Breaking Change 部分应该以短语 “BREAKING CHANGE：” 开始，然后是不兼容变动的摘要，空行，不兼容变动的详细描述，其中还包括迁移指令

类似地，Deprecation 部分应该以 “DEPRECATED：“ 开始，然后是对已弃用内容的简短描述，空行，以及对已弃用内容的详细描述，其中还提到了推荐的内容。


### Revert commits

还有一种特殊情况，如果当前 commit 用于撤销以前的 commit，则必须以`revert:`开头，后面跟着被撤销 Commit 的 Header 部分。

commit message body部分 中的内容应该包含

- 被撤销的 commit 的 SHA 标识符，格式应该为：`This reverts commit <SHA>.`
- 对撤销原因的清晰描述

```
revert: feat(pencil): add 'graphiteWidth' option

This reverts commit 667ecc1654a317a13331b17617d973392f415f02.

```

body 部分的格式是固定的，必须写成`This reverts commit <hash>.`，其中的`hash`是被撤销 commit 的 SHA 标识符。



### 插件推荐

#### JetBrain 全家桶

IDEA、WebStorm 等 IDE 中可以安装插件**Git Commit Template**来方便进行 commit 信息的填写，效果如下图所示：

![image-20211121211907116](https://raw.githubusercontent.com/zhicheng-ning/Pic-Go/main/md/image-20211121211907116.png)

除此之外，该插件还可以配置，在提交 Commit 之前进行代码质量的扫描、分析以及单元测试的运行等等操作。

![image-20211121212228999](https://raw.githubusercontent.com/zhicheng-ning/Pic-Go/main/md/image-20211121212228999.png)

#### VsCode

Vscode 中也有类似的插件`git-commit-plugin`，如下图所示：

![image-20211121212935411](https://raw.githubusercontent.com/zhicheng-ning/Pic-Go/main/md/image-20211121212935411.png)

#### 未完待续......

