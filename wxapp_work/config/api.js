const http = uni.$u.http

export const getCode = (params) => http.get(`/getCode?Code=${params}`)

export const getDictData = (params) => http.get(`/getDictData?typeName=${params}`)

export const getWorkById = (params) => http.get(`/getWorkById?id=${params}`)

export const insUser = (data) => http.post(`/insUser`, data)

export const editUser = (data) => http.post(`/editUser`, data)

export const getWorkList = (params) => http.get(`/getWorkList?openId=${params.openId}&pageSizeApi=${params.pageSize}&pageNumApi=${params.pageNum}`)

export const getSearchWorkList = (data) => http.post(`/getSearchWorkList`, data)
