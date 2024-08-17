/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-08-12 16:36:24
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-08-17 12:13:34
 * @FilePath: \vue-example-main\src\api\score.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import http from "@/utils/httpRequest";

// 查询学生成绩
export function queryAll(){
    return http({
        url: "/api/score/queryAll",
        method: "post"
    })
}


// 查看所有学生成绩排名(总分、平均分、个人信息)
export function queryRanking(data){
    return http({
        url: "/score/queryRanking",
        method: "post",
        data: ''
    })
}





