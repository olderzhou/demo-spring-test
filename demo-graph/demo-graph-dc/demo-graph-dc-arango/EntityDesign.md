## 实体关系设计

### 活动| activity
***
| 名称  | 类型 | 长度    | 描述  |
| :-------|------: |-----------| :---------: |
| type  | int | 1     | 活动类型 |
| title  | string | 128     | 活动标题 |
| startDt  | DateTime   | undefined | 活动开始时间 |
| endDt  | DateTime   | undefined | 活动结束时间 |
| createDt | Date  |       | 活动创建时间   |
| _id | string  |       |id   |
| _key | string  |       | key   |
| _rev | string  |       | rev   |


### 活动参与人| activity-user
***
| 名称  | 类型 | 长度    | 描述  |
| :-------|------: |-----------| :---------: |
| name  | string | 128     | 参与人名称 |
| mobile  | string | 15     | 参与人联系电话 |
| createDt | Date  |       | 参与人创建时间   |
| updateDt | Date  |       | 参与人创建时间   |
| _id | string  |       |id   |
| _key | string  |       | key   |
| _rev | string  |       | rev   |


### 活动参与| activity-attend
***
| 名称  | 类型 | 长度    | 描述  |
| :-------|------: |-----------| :---------: |
| type  | int | 1     | 活动类型 |
| title  | string | 128     | 活动标题 |
| createDt | Date  |       | 活动创建时间   |
| _id | string  |       |id   |
| _key | string  |       | key   |
| _rev | string  |       | rev   |
| _to | string  |       | rev   |
| _from | string  |       | rev   |


### 活动注册| activity-register
***
| 名称  | 类型 | 长度    | 描述  |
| :-------|------: |-----------| :---------: |
| type  | int | 1     | 活动类型 |
| title  | string | 128     | 活动标题 |
| createDt | Date  |       | 活动创建时间   |
| _id | string  |       |id   |
| _key | string  |       | key   |
| _rev | string  |       | rev   |
| _to | string  |       | rev   |
| _from | string  |       | rev   |


### 活动调查| activity-investigate
***
| 名称  | 类型 | 长度    | 描述  |
| :-------|------: |-----------| :---------: |
| type  | int | 1     | 活动类型 |
| title  | string | 128     | 活动标题 |
| createDt | Date  |       | 活动创建时间   |
| _id | string  |       |id   |
| _key | string  |       | key   |
| _rev | string  |       | rev   |
| _to | string  |       | rev   |
| _from | string  |       | rev   |