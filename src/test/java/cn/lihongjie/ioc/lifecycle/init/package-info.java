/**
 *
 * beanFactory  初始化的过程只是读配置文件而已, 所有的操作都是在postprocessor中进行的
 *
 * postprocessor 进行处理之后, 一般就是把配合文件的中的占位符给解析
 *
 *
 * 然后解析初始化
 *
 * 首先实例化对象
 *
 * 然后设置属性
 *
 * 最后的话设置各种aware接口
 *
 *
 * bean postprocessor
 *
 *
 * @author 982264618@qq.com
 */
package cn.lihongjie.ioc.lifecycle.init;