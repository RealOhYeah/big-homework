/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

export function getShowList(data){
    return http({
        url: "/channelList/queryByShowId",
        method: "get",
        params: data
    })
}