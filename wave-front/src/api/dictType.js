import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/api/dictType/list/1/10',
    method: 'get',
    params
  })
}
