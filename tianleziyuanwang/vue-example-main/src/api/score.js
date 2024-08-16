import http from "@/utils/httpRequest";

// 查询学生成绩
export function queryAll(){
    return http({
        url: "/api/score/queryAll",
        method: "post"
    })
}

// 查询学生排名
export function queryRanking(){
    return http({
        url: "/api/score/queryRanking",
        method: "post"
    })
}


