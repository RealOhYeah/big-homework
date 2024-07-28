
/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

/**
 * 分页获取下载列表
 * @param {*} data 
 * @returns 
 */
export function pagingtoGetData(data) {
    return http({
        url: "/file/queryPublicFileWithoutMyself",
        method: "post",
        params: data
    })
}