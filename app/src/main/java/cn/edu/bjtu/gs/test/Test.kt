package cn.edu.bjtu.gs.test

/**
 * Author: fanyafeng
 * Date: 2023/9/17 11:26
 * Email: fanyafeng@live.cn
 * Description:
 *///Github See: https://github.com/fanyafeng



interface IAppearance {
    //外貌
    fun height(): Int//身高
    fun weight(): Int//体重
    fun skinColor(): Int//肤色
    fun hairColor(): Int//头发颜色
    fun hairStyle(): Int//头发样式
    fun faceStyle(): Int//脸型
    fun faceColor(): Int//脸色
    fun eyeStyle(): Int//眼睛样式
    fun eyeColor(): Int//眼睛颜色
    fun noseStyle(): Int//鼻子样式
}

interface IBehavior {
    //行为
    fun moveSpeed(): Int//移动速度
    fun attackSpeed(): Int//攻击速度
}

interface IAbility {
    //能力
    fun attackPower(): Int//攻击力
    fun defensePower(): Int//防御力
    fun speed(): Int//速度
    fun attackDistance(): Int//攻击距离
    fun attackInterval(): Int//攻击间隔
    fun attackScope(): Int//攻击范围
    fun attackType(): Int//攻击类型
    fun attackEffect(): Int//攻击效果
    fun attackEffectTime(): Int//攻击效果持续时间
    fun attackEffectProbability(): Int//攻击效果触发概率
    fun attackEffectScope(): Int//攻击效果触发范围
    fun attackEffectInterval(): Int//攻击效果触发间隔
    fun attackEffectType(): Int//攻击效果触发类型
    fun attackEffectEffect(): Int//攻击效果触发效果
    fun attackEffectEffectTime(): Int//攻击效果触发效果持续时间
    fun attackEffectEffectProbability(): Int//攻击效果触发效果触发概率
}

interface ICharacter {
    //角色
    fun getCharacter(): String//角色
    fun getCharacterType(): String//角色类型
    fun getCharacterLevel(): String//角色等级
    fun getCharacterLevelType(): String//角色等级类型
    fun getCharacterLevelValue(): String//角色等级值
    fun getCharacterLevelValueMax(): String//角色等级最大值
    fun getCharacterLevelValueMin(): String//角色等级最小值
    fun getCharacterLevelValueInterval(): String//角色等级值间隔
    fun getCharacterLevelValueIntervalMax(): String//角色等级值间隔最大值
    fun getCharacterLevelValueIntervalMin(): String//角色等级值间隔最小值
    fun getCharacterLevelValueIntervalType(): String//角色等级值间隔类型
    fun getCharacterLevelValueIntervalTypeMax(): String//角色等级值间隔类型最大值
    fun getCharacterLevelValueIntervalTypeMin(): String//角色等级值间隔类型最小值
}


class Role : IAppearance, IBehavior, IAbility, ICharacter {
    override fun height(): Int {
        return 0
    }

    override fun weight(): Int {
        return 0
    }

    override fun skinColor(): Int {
        return 0
    }

    override fun hairColor(): Int {
        return 0
    }

    override fun hairStyle(): Int {
        return 0
    }

    override fun faceStyle(): Int {
        return 0
    }

    override fun faceColor(): Int {
        return 0
    }

    override fun eyeStyle(): Int {
        return 0
    }

    override fun eyeColor(): Int {
        return 0
    }

    override fun noseStyle(): Int {
        return 0
    }

    override fun moveSpeed(): Int {
        return 0
    }

    override fun attackSpeed(): Int {
        return 0
    }

    override fun attackPower(): Int {
        return 0
    }

    override fun defensePower(): Int {
        return 0
    }

    override fun speed(): Int {
        return 0
    }

    override fun attackDistance(): Int {
        return 0
    }

    override fun attackInterval(): Int {
        return 0
    }

    override fun attackScope(): Int {
        return 0
    }

    override fun attackType(): Int {
        return 0
    }

    override fun attackEffect(): Int {
        return 0
    }

    override fun attackEffectTime(): Int {
        return 0
    }

    override fun attackEffectProbability(): Int {
        return 0
    }

    override fun attackEffectScope(): Int {
        return 0
    }

    override fun attackEffectInterval(): Int {
        return 0
    }

    override fun attackEffectType(): Int {
        return 0
    }

    override fun attackEffectEffect(): Int {
        return 0
    }

    override fun attackEffectEffectTime(): Int {
        return 0
    }

    override fun attackEffectEffectProbability(): Int {
        return 0
    }

    override fun getCharacter(): String {
        return ""
    }

    override fun getCharacterType(): String {
        return ""
    }

    override fun getCharacterLevel(): String {
        return ""
    }

    override fun getCharacterLevelType(): String {
        return ""
    }

    override fun getCharacterLevelValue(): String {
        return ""
    }

    override fun getCharacterLevelValueMax(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueMin(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueInterval(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueIntervalMax(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueIntervalMin(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueIntervalType(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueIntervalTypeMax(): String {
        TODO("Not yet implemented")
    }

    override fun getCharacterLevelValueIntervalTypeMin(): String {
        TODO("Not yet implemented")
    }
}


fun main(args: Array<String>) {


}